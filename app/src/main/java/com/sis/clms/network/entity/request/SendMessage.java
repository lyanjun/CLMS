package com.sis.clms.network.entity.request;

import com.sis.clms.entity.Bean;

/**
 * 请求体
 *
 * Created by DELL on 2017/6/5.
 */

public class SendMessage implements Bean{
    private Header header;
    private Body body;

    public SendMessage(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
