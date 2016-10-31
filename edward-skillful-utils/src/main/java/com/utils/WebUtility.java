
package com.utils;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * Web 路径工具类
 *
 * @author tianzhonghong
 *
 */
public final class WebUtility {

    private static Logger logger = LoggerFactory.getLogger(WebUtility.class);

    private WebUtility() {

    }

    /**
     * 取得带相同前缀的Request Parameters
     *
     * 返回的结果的Parameter名已去除前缀.
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {

        Validate.notNull(request, "Request must not be null");
        Enumeration paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap<String, Object>();
        if (prefix == null) {
            prefix = "";
        }
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            if ("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                if (values == null || values.length == 0) {
                } else if (values.length > 1) {
                    params.put(unprefixed, values);
                } else {
                    params.put(unprefixed, values[0]);
                }
            }
        }
        return params;
    }

    /**
     * 组合Parameters生成Query String的Parameter部分, 并在paramter name上加上prefix.
     *
     * @see #getParametersStartingWith
     */
    public static String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {

        if (params == null || params.size() == 0) {
            return "";
        }

        if (prefix == null) {
            prefix = "";
        }

        StringBuilder queryStringBuilder = new StringBuilder();
        Iterator<Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            queryStringBuilder.append(prefix).append(entry.getKey()).append('=').append(entry.getValue() == null ? "" : entry.getValue());
            if (it.hasNext()) {
                queryStringBuilder.append('&');
            }
        }
        return queryStringBuilder.toString();
    }

    /**
     * 检查是否是IE 6
     */
    public static boolean isIE6(String userAgent)
    {

        return (userAgent.indexOf("MSIE 6.0") != -1);
    }

    /**
     *
     * 导出Excel并下载
     *
     * @author tianzhonghong
     * @date 2014年1月7日下午7:54:59
     *
     * @param response
     * @param request
     * @param params
     *            excel文件中需要使用的参数
     * @param fileName
     *            导出的excel文件名
     * @param templateFileName
     *            导出的excel模版文件名
     * @param totalPages 总页数
     */
    public static void exportToDownload(HttpServletResponse response, HttpServletRequest request, Map<String, Object> params, String fileName, String templateFileName, Integer totalPages) {

        XLSTransformer transformer = new XLSTransformer();

        InputStream inp = null;
        OutputStream outputStream = null;
        try {

            WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request);
            String webRoot = ctx.getServletContext().getRealPath("/");
            String filePath = webRoot + File.separator + "WEB-INF" + File.separator + "template" + File.separator + templateFileName;
            inp = new FileInputStream(filePath);

            Workbook workBook = transformer.transformXLS(inp, params);

            // 合并单元格
            Object regions = params.get("regions");
            if (null != regions) {
                List<CellRangeAddress> regionList = (List<CellRangeAddress>) regions;
                Sheet sheet = workBook.getSheetAt(0);
                for (CellRangeAddress region : regionList) {
                    sheet.addMergedRegion(region);
                }

            }

            // 隐藏列
            /*
             * Object hideColumns = params.get("hideColumns");
             * if (null != hideColumns) {
             * short[] columns = (short[]) hideColumns;
             * XLSTransformer xlsTransformer = new XLSTransformer();
             * xlsTransformer.setColumnsToHide(columns);
             * }
             */

            resetCellFormula((HSSFWorkbook) workBook);

            outputStream = response.getOutputStream();
            response.reset();

            boolean isMSIE = HttpUtils.isMSBrowser(request);
            if (isMSIE) {//如果是微软的浏览器,文件名使用utf-8进行编码
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {//如果不是,使用万能解决乱码代码
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
            if (totalPages != null) {
                response.setHeader("totalPages", totalPages.toString());
            }
            response.setContentType("application/x-msdownload");

            workBook.write(outputStream);
            outputStream.flush();

        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        } finally {
            IOUtils.closeQuietly(inp);
            IOUtils.closeQuietly(outputStream);
        }
    }

    /**
     *
     * 重新设置单元格计算公式
     */
    private static void resetCellFormula(HSSFWorkbook wb) {

        HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(wb);
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            HSSFSheet sheet = wb.getSheetAt(i);
            int rows = sheet.getLastRowNum() + 1;
            for (int j = 0; j < rows; j++) {
                HSSFRow row = sheet.getRow(j);
                if (row == null)
                    continue;
                int cols = row.getLastCellNum();
                for (int k = 0; k < cols; k++) {
                    HSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
                        cell.setCellFormula(cell.getCellFormula());
                        cell = e.evaluateInCell(cell);
                    }
                }
            }
        }
    }
}
