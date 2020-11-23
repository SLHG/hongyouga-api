$(
    function () {
        var dayNum = 5;
        $.get("/service/appointment/getAppointmentList", {
            "startDate": getFormatDate(0), "dayNum": dayNum
        }, function (data) {
            for (let i = 0; i <= dayNum; i++) {
                let date = new Date();
                date.setDate(date.getDate() + i);
                $("#dateInfo").append("<td>" + getFormatDate(i) + Week[date.getDay()] + "</td>");
                let resultElement = data.result[i];
                for (let j = 0; j < resultElement.length; j++) {
                    let tr = $("#table tr:eq(" + (j + 1) + ")");
                    if (tr.length > 0) {
                        tr.append("<td><a href='/service/classinfo.html?classId=" + resultElement[j].classId + "'>" + resultElement[j].className + "</a></td>");
                    } else {
                        $("#table").append("<tr><td><a href='/service/classinfo.html?classId=" + resultElement[j].classId + "'>" + resultElement[j].className + "</a></td></tr>");
                    }
                }
            }
        })
    }
);
const Week = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];

function getFormatDate(n) {
    let nowDate = new Date();
    nowDate.setDate(nowDate.getDate() + n);
    let year = nowDate.getFullYear();
    let month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1) : nowDate.getMonth() + 1;
    let date = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate.getDate();
    return year + "-" + month + "-" + date;
}
