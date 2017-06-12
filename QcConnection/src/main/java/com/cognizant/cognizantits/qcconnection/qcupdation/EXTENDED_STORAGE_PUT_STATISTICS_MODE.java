/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum EXTENDED_STORAGE_PUT_STATISTICS_MODE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   NO_STATISTICS(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:13 */     0),  CIENT_FILES_ONLY(
/* 14:   */   
/* 15:   */ 
/* 16:   */ 
/* 17:   */ 
/* 18:19 */     1),  SERVER_FILES_ONLY(
/* 19:   */   
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:25 */     2),  FILES_FOR_MOVE(
/* 24:   */   
/* 25:   */ 
/* 26:   */ 
/* 27:   */ 
/* 28:31 */     4);
/* 29:   */   
/* 30:   */   private final int value;
/* 31:   */   
/* 32:   */   private EXTENDED_STORAGE_PUT_STATISTICS_MODE(int value)
/* 33:   */   {
/* 34:35 */     this.value = value;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public int comEnumValue()
/* 38:   */   {
/* 39:36 */     return this.value;
/* 40:   */   }
/* 41:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.EXTENDED_STORAGE_PUT_STATISTICS_MODE
 * JD-Core Version:    0.7.0.1
 */