(function(c, b) {
    function g(a) {
        function d() {
            try {
                c.documentElement.doScroll("left")
            } catch (h) {
                setTimeout(d, 0);
                return
            }
            a()
        }
        var e = !1;
        if (c.addEventListener)
            c.addEventListener("DOMContentLoaded", function() {
                a();
                e = !0
            }, !1),
            b.addEventListener("load", function() {
                e || a()
            }, !1);
        else if (b.attachEvent)
            b.ActiveXObject && b === b.top ? d() : b.attachEvent("onload", a);
        else {
            var f = b.onload;
            window.onload = function() {
                "function" === typeof f && f();
                a()
            }
        }
    }
    if (!b.ninja_x9_from_tracjs) {
        b.ninja_x9_from_tracjs = !0;
        var d = "https:" == c.location.protocol ? "https://" : "http://";
        (new Image).src = d + "sync.shinobi.jp/v2/sync/ne?r=" + encodeURIComponent(d + "adm.shinobi.jp/chikayo/cookiesync?uid=");
        g(function() {
            var a = c.createElement("script");
            a.charset = "utf-8";
            a.async = !0;
            a.src = "//x9.shinobi.jp/ufo/453134574";
            a.type = "text/javascript";
            c.body.appendChild(a)
        })
    }
}
)(document, window);