/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_ATTACH
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   TDATT_COPY(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     1),  TDATT_MOVE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     2),  TDATT_LINK(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     3),  TDATT_COPY_ASINCHRONE(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     4);
/* 41:   */   
/* 42:   */   private final int value;
/* 43:   */   
/* 44:   */   private TDAPI_ATTACH(int value)
/* 45:   */   {
/* 46:50 */     this.value = value;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int comEnumValue()
/* 50:   */   {
/* 51:51 */     return this.value;
/* 52:   */   }
/* 53:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_ATTACH
 * JD-Core Version:    0.7.0.1
 */