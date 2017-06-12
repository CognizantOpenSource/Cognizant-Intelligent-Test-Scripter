/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_SETTINGS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   TDAPI_STARTVIRTUAL_VALUE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:13 */     -10);
/* 14:   */   
/* 15:   */   private final int value;
/* 16:   */   
/* 17:   */   private TDAPI_SETTINGS(int value)
/* 18:   */   {
/* 19:17 */     this.value = value;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public int comEnumValue()
/* 23:   */   {
/* 24:18 */     return this.value;
/* 25:   */   }
/* 26:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_SETTINGS
 * JD-Core Version:    0.7.0.1
 */