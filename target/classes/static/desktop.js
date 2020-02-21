$(".app-content").ready(function () {

    // receive first login message
    this.receiveFirstLoginMessage();

    // side bar menu clicked
    $(".desktop-side-bar-menu").click(function () {
        const submenu = $(this).next();
        submenu.slideToggle(500);
        submenu.siblings("ul").hide(500);
    });
})

function loadPage(page) {
    if (page === 'list-incident-by-employee') {
        $('#app-content-load').load('features/incident_management/list-incident-by-employee/list-incident-by-employee.html');
    }
}

function receiveFirstLoginMessage() {
    const username = "user";
    const password = "pass";
    const command = {"whoIAm": "بهرام"};
    $.ajax({
        url: serverUrl() + "/message/first-login",
        type: "POST",
        data: JSON.stringify(command),
        contentType: "application/json; charset=utf-8",
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        },
        success: function (data, status) {
            showFirstMessage(data.message);
        },
        error: function (errorMessage) {
            alert("Some thing wrong happened!")
        }
    });
}

function showFirstMessage(message) {
    $("#first-login-message-alert").fadeIn(2000, function () {
        $("#first-login-message-alert").html(message);
    });
}
