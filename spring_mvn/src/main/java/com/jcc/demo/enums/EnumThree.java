package com.jcc.demo.enums;

public enum EnumThree {
	ONE(){
		public int getV() {
			return 1;
		}
	},
	TWO(){
		@Override
		public int getV() {
			return 2;
		}
	},
	THREE(){
		@Override
		public int getV() {
			return 3;
		}
		
	};
	public abstract int getV();
}
