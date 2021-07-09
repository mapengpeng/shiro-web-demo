<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统设置</title>
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
                <label class="layui-form-label required">角色</label>
                <div class="layui-input-block">
                    <input type="text" name="roles" lay-verify="required" lay-reqtext="" placeholder=""  value="" class="layui-input">
                    <tip>新增角色编码，多个角色用逗号（,）分隔</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">url</label>
                <div class="layui-input-block">
                    <input type="text" name="url" lay-verify="required" lay-reqtext="" placeholder=""  value="" class="layui-input">
                    <tip>资源路径</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="setting">新增权限</button>
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
                url: 'saveAuthorty',
                data: data.field,
                dataType: 'json',
                type: 'post',
                success: function (res) {
                    layer.msg(res.msg);
                }
            })
            return false;
        });

    });
</script>
</body>
</html>