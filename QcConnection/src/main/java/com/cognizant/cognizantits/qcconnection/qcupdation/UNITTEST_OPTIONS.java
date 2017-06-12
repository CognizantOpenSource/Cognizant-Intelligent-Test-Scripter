/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum UNITTEST_OPTIONS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   UNIT_TEST_DISABLE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:13 */     -1),  UNIT_TEST_EXECUTE(
/* 14:   */   
/* 15:   */ 
/* 16:   */ 
/* 17:   */ 
/* 18:19 */     0),  UNIT_TEST_RECORD(
/* 19:   */   
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:25 */     1);
/* 24:   */   
/* 25:   */   private final int value;
/* 26:   */   
/* 27:   */   private UNITTEST_OPTIONS(int value)
/* 28:   */   {
/* 29:29 */     this.value = value;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public int comEnumValue()
/* 33:   */   {
/* 34:30 */     return this.value;
/* 35:   */   }
/* 36:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.UNITTEST_OPTIONS
 * JD-Core Version:    0.7.0.1
 */