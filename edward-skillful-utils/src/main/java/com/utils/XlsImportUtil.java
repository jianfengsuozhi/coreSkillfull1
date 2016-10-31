
package com.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class XlsImportUtil {

    private static Logger logger = LoggerFactory.getLogger(XlsImportUtil.class);

    /**
     * TODO 方法的作用是？
     *
     * @author zll
     * @version v2.0.8
     * @date Apr 9, 2014 6:41:33 PM
     *
     * @param wb
     * @param startRow
     *            开始行号（如果是第一行的话应为0）
     * @param startCol
     *            开始列号（如果是第一列的话应为0）
     * @param clazz
     *            要实例的Bean的类型
     * @param beanProps
     *            bean的属性名称列表，需要与Excel模板中的顺序一致。
     * @return
     */
    public static <T> List<BindingResult> parse(Workbook wb, int startRow, int startCol, Class<T> clazz, String[] beanProps, String[] propLabels) {

        logger.trace("开始解析用户上传的Excel模板");

        Sheet sheet = wb.getSheetAt(0);
        int i = 0;

        List<BindingResult> list = new ArrayList<BindingResult>();

        while (true) {
            logger.trace("读取第{}行的数据", startRow + i + 1);
            Row row = sheet.getRow(startRow + i);
            if (row == null) {
                logger.trace("Row为null，读取完毕");
                break;
            }
            i++;

            Cell cell = row.getCell(startCol);
            // 判断是否是空白行
            int blankCells = 0;
            for (int j = 0; j < beanProps.length; j++) {
                cell = row.getCell(startCol + j);
                if (cell == null) {
                    logger.trace("Cell为null，读取完毕");
                    blankCells++;
                } else {
                    try {
                        Object val = getCellValue(cell);
                        if (val == null) {
                            logger.trace("Cell的值为null，读取完毕");
                            blankCells++;
                        }
                    } catch (Exception e) {
                        // 假如序号这一列用户输入为字母，会出错。但有值的情况下，不应认为是空白行
                    }
                }
            }
            if (blankCells == beanProps.length) {
                logger.trace("该行无可用数据，读取完毕");
                break;
            }

            BeanWrapper wrapper = new BeanWrapperImpl(clazz);
            BindingResult errors = new BeanPropertyBindingResult(wrapper.getWrappedInstance(), "result");
            for (int j = 0; j < beanProps.length; j++) {

                String field = beanProps[j];
                String label = propLabels[j];
                cell = row.getCell(startCol + j);

                if (cell == null) {
                    wrapper.setPropertyValue(field, null);
                    continue;
                }
                Object val = null;
                try {
                    val = getCellValue(cell);
                    wrapper.setPropertyValue(field, val);
                } catch (Exception e) {
                    logger.trace(e.getMessage(), null, e);
                    errors.rejectValue(field, null, label + "数据类型不正确，原始值是\"" + val + "\"。");
                }
                logger.trace("\t{}: cellValue={}, error={}", new Object[] { startCol + j + 1, val, errors.getFieldError(field) });
            }

            list.add(errors);
        }

        return list;
    }

    /**
     * 根据单元个特定格式获取其数据
     *
     * @author zll
     * @version v2.0.8
     * @date Apr 10, 2014 8:10:27 PM
     *
     * @param cell
     *            Excel单元格
     * @return 单元格的值
     */
    private static Object getCellValue(Cell cell) {

        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            return cell.getBooleanCellValue();
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue();
            }
            return cell.getNumericCellValue();
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
        case Cell.CELL_TYPE_BLANK:
            break;
        case Cell.CELL_TYPE_ERROR:
            break;
        case Cell.CELL_TYPE_FORMULA:
            break;
        }
        return null;
    }

    /**
     * 从MultipartFile中读取excel数据
     *
     * @param file
     * @return
     * @throws Exception
     *
     * @author Tantal
     */
    public static Workbook getExcelWbFromFile(MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();
        Workbook wb = null;
        if (fileName.endsWith(".xls")) {
            try {
                wb = new HSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                throw new Exception("读取xls格式文件错误", e);
            }
        } else if (fileName.endsWith(".xlsx")) {
            try {
                wb = new XSSFWorkbook(file.getInputStream());
            } catch (Exception e) {
                throw new Exception("读取xls格式文件错误", e);
            }
        } else {
            throw new Exception("文件格式错误");
        }
        return wb;
    }
}
