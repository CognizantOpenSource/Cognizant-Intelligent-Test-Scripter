/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagBPT_VERSION
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   BPT_VERSION_3(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     3),  BPT_VERSION_4(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     4);
/* 25:   */   
/* 26:   */   private final int value;
/* 27:   */   
/* 28:   */   private tagBPT_VERSION(int value)
/* 29:   */   {
/* 30:29 */     this.value = value;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public int comEnumValue()
/* 34:   */   {
/* 35:30 */     return this.value;
/* 36:   */   }
/* 37:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagBPT_VERSION
 * JD-Core Version:    0.7.0.1
 */