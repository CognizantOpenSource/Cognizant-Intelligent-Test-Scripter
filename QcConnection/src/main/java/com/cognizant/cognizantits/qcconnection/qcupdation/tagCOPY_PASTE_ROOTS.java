/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagCOPY_PASTE_ROOTS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   CPR_ANALYSIS_PRIVATE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     -2147483646),  CPR_ANALYSIS_PUBLIC(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:22 */     -2147483645);
/* 22:   */   
/* 23:   */   private final int value;
/* 24:   */   
/* 25:   */   private tagCOPY_PASTE_ROOTS(int value)
/* 26:   */   {
/* 27:26 */     this.value = value;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public int comEnumValue()
/* 31:   */   {
/* 32:27 */     return this.value;
/* 33:   */   }
/* 34:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagCOPY_PASTE_ROOTS
 * JD-Core Version:    0.7.0.1
 */