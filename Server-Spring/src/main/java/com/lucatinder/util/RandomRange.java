package com.lucatinder.util;

public class RandomRange {

	static public int devuelveEnRango(int a, int b) {

		double randomNumber = (Math.random() * 100);
		b-=a;
		return (int) (((randomNumber *= b) / 100)+a);

	}
}
