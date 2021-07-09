<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>密码加密</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/css/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${request.contextPath}/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">请输入密码</label>
                <div class="layui-input-block">
                    <input type="text" name="password" lay-verify="required" lay-reqtext="" placeholder=""  value="" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="setting">加密</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${request.contextPath}/css/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(setting)', function (data) {
            $.ajax({
                url: 'doEncryPassword',
                data: data.field,
                dataType: 'text',
                type: 'post',
                success: function (res) {
                    layer.msg(res);
                }
            })
            return false;
        });

    });
</script>
</body>
</html>