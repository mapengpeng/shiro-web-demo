<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/css/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${request.contextPath}/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <#--                    <div class="layui-form-item">-->
                    <#--                        <div class="layui-inline">-->
                    <#--                            <label class="layui-form-label">用户姓名</label>-->
                    <#--                            <div class="layui-input-inline">-->
                    <#--                                <input type="text" name="username" autocomplete="off" class="layui-input">-->
                    <#--                            </div>-->
                    <#--                        </div>-->
                    <#--                        <div class="layui-inline">-->
                    <#--                            <label class="layui-form-label">用户性别</label>-->
                    <#--                            <div class="layui-input-inline">-->
                    <#--                                <input type="text" name="sex" autocomplete="off" class="layui-input">-->
                    <#--                            </div>-->
                    <#--                        </div>-->
                    <#--                        <div class="layui-inline">-->
                    <#--                            <label class="layui-form-label">用户城市</label>-->
                    <#--                            <div class="layui-input-inline">-->
                    <#--                                <input type="text" name="city" autocomplete="off" class="layui-input">-->
                    <#--                            </div>-->
                    <#--                        </div>-->
                    <#--                        <div class="layui-inline">-->
                    <#--                            <label class="layui-form-label">用户职业</label>-->
                    <#--                            <div class="layui-input-inline">-->
                    <#--                                <input type="text" name="classify" autocomplete="off" class="layui-input">-->
                    <#--                            </div>-->
                    <#--                        </div>-->
                    <#--                        <div class="layui-inline">-->
                    <#--                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>-->
                    <#--                        </div>-->
                    <#--                    </div>-->
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 强制下线</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="${request.contextPath}/css/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            layer = layui.layer,
            table = layui.table;

        table.render({
            id: "onLineUserTable",
            elem: '#currentTableId',
            url: 'getOnlineUser',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'sessionId', title: 'ID', sort: true},
                {field: 'username', title: '用户名'},
                // {title: '操作', toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var checkStatus = table.checkStatus('onLineUserTable');
                var sessionId = checkStatus.data[0].sessionId;
                console.log(sessionId)
                $.ajax({
                    url: 'doForceLogout',
                    data: {"sessionId": sessionId},
                    type: 'post',
                    dataType: 'json',
                    success: function (data) {
                        layer.msg(data.msg);
                    }
                })
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });
    });
</script>

</body>
</html>