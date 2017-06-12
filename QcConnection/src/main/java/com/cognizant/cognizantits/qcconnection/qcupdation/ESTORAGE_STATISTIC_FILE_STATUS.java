/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum ESTORAGE_STATISTIC_FILE_STATUS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   FILE_IN_CLIENT(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:13 */     1),  FILE_IN_SERVER(
/* 14:   */   
/* 15:   */ 
/* 16:   */ 
/* 17:   */ 
/* 18:19 */     2),  FILE_CHANGE(
/* 19:   */   
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:25 */     4),  FILE_MOVED(
/* 24:   */   
/* 25:   */ 
/* 26:   */ 
/* 27:   */ 
/* 28:31 */     8),  FILE_MOVING(
/* 29:   */   
/* 30:   */ 
/* 31:   */ 
/* 32:   */ 
/* 33:37 */     16);
/* 34:   */   
/* 35:   */   private final int value;
/* 36:   */   
/* 37:   */   private ESTORAGE_STATISTIC_FILE_STATUS(int value)
/* 38:   */   {
/* 39:41 */     this.value = value;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int comEnumValue()
/* 43:   */   {
/* 44:42 */     return this.value;
/* 45:   */   }
/* 46:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ESTORAGE_STATISTIC_FILE_STATUS
 * JD-Core Version:    0.7.0.1
 */