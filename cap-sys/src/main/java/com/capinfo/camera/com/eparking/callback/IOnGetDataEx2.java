package com.capinfo.camera.com.eparking.callback;

import com.capinfo.camera.com.eparking.data.PlateResult_Ex;
import com.sun.jna.Callback;

public interface IOnGetDataEx2 extends Callback
{
	public void callback(PlateResult_Ex.ByReference plateResult, long dwUser);
}

