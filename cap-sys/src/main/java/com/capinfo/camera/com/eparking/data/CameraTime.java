package com.eparking.data;

import com.sun.jna.Structure;

public class CameraTime extends Structure
{
	public static class ByReference extends CameraTime implements Structure.ByReference {}
	public static class ByValue extends CameraTime implements Structure.ByValue {}
	public int Year; 		/* 年 */
	public int Month; 		/* 月 */
	public int Day; 		/* 日 */
	public int Hour; 		/* 时 */
	public int Minute; 		/* 分 */
	public int Second; 		/* 秒 */
	public int Millisecond; /* 微秒 */
}