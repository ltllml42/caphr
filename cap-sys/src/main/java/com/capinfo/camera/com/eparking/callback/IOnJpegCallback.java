package com.capinfo.camera.com.eparking.callback;

import com.sun.jna.Callback;

public interface IOnJpegCallback extends Callback
{
	public void callback(com.eparking.data.DevData_info.ByReference JpegInfo, long dwUser);
}
