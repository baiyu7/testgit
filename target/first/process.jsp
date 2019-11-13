<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.fileDownload.js" ></script> -->
    <script type="text/javascript">

        $(function () {
            uploadFile();
        });

        function uploadFile() {
            $(".file").change(function () {
                var formData2 = $(this).parent(); //得到表单

                $.ajax({
                    url: '${pageContext.request.contextPath}/AppFileService.action?fn=upload&r=' + Math.random(),
                    type: 'POST',
                    Accept: 'text/html;charset=UTF-8',
                    cache: false,
                    contentType: "multipart/form-data",
                    data: new FormData(formData2[0]),
                    processData: false,
                    contentType: false,
                    xhr: function () {
                        myXhr = $.ajaxSettings.xhr();
                        if (myXhr.upload) { // check if upload property exists
                            myXhr.upload.addEventListener('progress', function (e) {
                                var loaded = e.loaded;//已经上传大小情况
                                var tot = e.total;//附件总大小
                                var per = Math.floor(100 * loaded / tot);  //已经上传的百分比
                                $("#son").html(per + "%");
                                $("#son").css("width", per + "%");
                                console.log('附件总大小 = ' + loaded);
                                console.log('已经上传大小 = ' + tot);
                            }, false); // for handling the progress of the upload
                        }
                        return myXhr;
                    },
                    success: function (data) {
                        console.log(data);
                        console.log("上传成功!!!!");

                    },
                    error: function () {
                        console.log("上传失败！");

                    }
                });
            });

        }
    </script>
    <style>

        #son {
            width: 0px;
            height: 30px;
            background: blue;
        }

    </style>

    <title>Insert title here</title>
</head>
<body>


<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="testfile" class="file"/>
</form>

<div id="son"></div>


</body>
</html>