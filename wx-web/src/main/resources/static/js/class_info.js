$(
    function () {
        let classId = getUrlParam("classId");
        if (classId == null) {
            classId = 1;
        }
        $.get("/service/class/getClassInfoById", {"classId": classId}, function (data) {
            let result = data.result;
            if (result != null) {
                $("#classInfo").append("课程:" + result.className + ",简介:" + result.classIntroduction);
            }
        });
    }
);

function getUrlParam(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    let r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}
