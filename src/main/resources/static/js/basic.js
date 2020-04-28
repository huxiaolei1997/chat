var basic = {
    ajax: function ($, option, callback) {
        $.ajax({
            method: option.method || 'POST',
            url: option.url,
            data: option.data
        }).done(function (msg) {
            // 如果接口调用成功
            if (msg.code == '0') {
                callback(msg);
            } else {
                // TODO
                console.log(msg.message);
            }
        }).fail(function () {
            console.log("接口调用失败");
        })
    }
}
