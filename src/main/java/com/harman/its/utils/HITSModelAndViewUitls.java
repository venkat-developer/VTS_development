package com.harman.its.utils;


public enum HITSModelAndViewUitls {
	
		HOME((short) 1, "home"), CONFIG((short) 2, "config");

		private short type;
		private String view;

		private HITSModelAndViewUitls(short type, String view) {
			this.type = type;
			this.view = view;
		}

		public static short getType(HITSModelAndViewUitls entity) {
			return entity.type;

		}

		public static String getView(HITSModelAndViewUitls entity) {
			return entity.view;
		}


}
