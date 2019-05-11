package com.eparking.data;

import com.sun.jna.Structure;

public class PlateLocation extends Structure
{
	public static class ByReference extends PlateLocation implements Structure.ByReference {}
	public static class ByValue extends PlateLocation implements Structure.ByValue {}

	public int Left; 		/* 左 */
	public int Top; 		/* 上 */
	public int Right; 		/* 右 */
	public int Bottom; 		/* 下 */
}