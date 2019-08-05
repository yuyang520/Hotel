package com.javaee.hotel.alipay.trade.page;

public interface AlipayInterfaec {
    public static String app_id = "2016101000649587";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCn" +
            "+ZrWHRV+KH53ZDgB6oZG74DBf556z6hqMoiFN9mrlRN9gNLHM+uIKtEPRRqDx3jsXTT2mWuFlczs/4enBqQjAktP" +
            "dVqmEG3ESG4sXVF7h0LdQHiUDZ8ZsN3RAby72QNK1wv9dieQnt0bE9rkvAAUGY7bbFNIcn7wkKPII+jQEf2NCKa9U/+" +
            "zrOcoIx3dPTT1jqfecSrJmNJdo0sV5jEFRs/dpKTTIGfF0Szfl8kgaOOYd4QACfhpmm+kARMWiu30WD2tinHPfRjBii" +
            "YYHMOJBBgfqs7WDufNg2jzpikQbcYUDckXyQGTCe7HnZoT5Tktin+bfs3/cb/IzU8gWP/RAgMBAAECggEABO3DCFNUJ" +
            "R6FD3XGWvAJvp0adxMKkGn1dCBFdzs7TNiT+NPF24h/ecBf4AXUEFfTCYR2oGHCEOpjV/TrgxAj0s8nbI5x+Xtz7RV" +
            "+/hhC4tAGOz3ADAAWUgepio91fUGR4ilLNcW4xXqT3E6J1rpZej2BvpiAHRkW9nIYDDBZjXldfog/gE1/2n+M2azY73" +
            "3k0QA6fEIZQ36nVsp/pwmAlojxq/3ergu3Q44FdnjJL9nfgkK9PFGRCpz2QRn7SeLZSTJ01VyEtmVzJZkt3AdckB90B" +
            "PxYNgyRz7lls0L1pOp11q7uMe/ker4+BXgb2e1rJQ8cGcsy+e7ux6nk3YxeUQKBgQDSXixFjfB0N9dWqfMrG268qEkT2" +
            "JZ4XJeP6bXf8SQiOHZ8/Xu2dfo9YXmI0XSqOR75xuR6NpLaRqthM3pLrj8v3y3aNwvtaHP94TOMCb9MxXr0C1rek2/h" +
            "Gnwms5eYZ81mFDUkX2kFXkIQLb6EsGCzQJyBFVPsvILf78M008B8RQKBgQDMaVZRZysUNCi4qrD/oAPx/g5mS8zqZH7z" +
            "t3GNjT2l5HByKyujKMc0vV1++xExuPP/5k8UB6lCDm6brVVWZtAt5t9NQVSSqIL5uMG063Tyxane7cpjOmWI21ZpbzqC" +
            "TDk8TX0z2PqfESPj9uigO892jXHmcPXtOaBeXt+yzUv8HQKBgB77Z6HGyccUAk7tMLcEj0aRslGN8HtBh8DWNscIiL3R" +
            "ewHlgzbYIUaw+GlCD+CSERHQTQ4Cw5YKGmtyXWyP+RZf1CzzNnp8i7i0VhclyFrSKs2Obo+hPzTz5Zz9jjIP95w1Fa6Jr" +
            "rnvq+MeGZUJNPSxa1tHfNi82rmIYkOBfDPRAoGAG4KBr2rnDU0HvfKa54wte7/pSDMjXNgxjbM+gQJlLZJU38iXktnGF" +
            "X72ukQnyD1P+TyRn+x4Bv/SOvlU5s/nbIYJv2fvbd1n4xvOVf7qOlIHzozKFBij2YtLUd06TpbbjRYQp42oDQhNgDyWih" +
            "oCjb3zekPxlP+QaaLzECk49LECgYEAl6kFN/JGFCH/yeVyxgKbSHW8vg4URul3LTPqo5pGRUtMfTnmuMI82cXJdocuTh" +
            "/0YnyjnsYJXo0fTRGzxVKJlLfrdnEynvP8VGq/AL9PtDdAWEZemQhdjD8oIsmpQ0FUIpBjLE0WgARdmxaNLhzIqYyc5ZJ" +
            "bKlyu+93vBj/nxKE=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjYbAlSo7ZuQeTwQ" +
            "Yu/YbDn29voV6XNBqlqbysdZOOeI//wXY3s8n5V/MMNlj6FYTvm8Jf/KooAxNXX4hhyyJzAZyXbszXE4S/UD5t9PFF5t" +
            "qCshSAMM5iIlahpZylaTyMD3MbyxtdrdtVOhF4jaPqw/4QviJSSVzuXr6i1eIzwiL27Sg0RJGGPoPPYYllMC3A478Fos" +
            "SkNFJNhoPbLuyGkfYw30AIze6CbPUoS3qkQfCfaYbMQCPN+gc/P2rZDDejAufU0iJ+1VREa2XyMzxOEUXC+notLZBbc" +
            "pri8ZBicaFXe6TdVDASEDNWn7fuUB7kVERmnqY5WTqseyYB5DQwwIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8585/alipay/checkPay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8585/alipay/checkPay";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //沙箱网关
    public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";

    // 仅支持JSON
    public static String format = "JSON";

}
