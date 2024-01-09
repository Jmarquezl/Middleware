package com.chipilinsoft.middleware.component;

import com.chipilinsoft.middleware.entity.BaseResponse;

public interface MessageProvider {
	void assertCode(BaseResponse response, String codigo);
}
