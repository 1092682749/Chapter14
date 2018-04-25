<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="./validate/validator.do" method="get">
        <table>
            <tr>
                <td>产品编号：</td>
                <td><input name="productId" id="productId"></td>
            </tr>
            <tr>
                <td>用户编号：</td>
                <td><input id="userId" name="userId"></td>
            </tr>
            <tr>
                <td>交易日期</td>
                <td><input name="date" id="date"></td>
            </tr>
            <tr>
                <td>价格:</td>
                <td><input id="price" name="price"></td>
            </tr>
            <tr>
                <td>数量:</td>
                <td><input id="quantity" name="quantity"></td>
            </tr>
            <tr>
                <td>交易金额：</td>
                <td><input name="amount" id="amount"></td>
            </tr>
            <tr>
                <td>用户邮件：</td>
                <td><input id="email" name="email"></td>
            </tr>
            <tr>
                <td>备注：</td>
                <td><textarea name="note" id="note" row="5" cols="20"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>