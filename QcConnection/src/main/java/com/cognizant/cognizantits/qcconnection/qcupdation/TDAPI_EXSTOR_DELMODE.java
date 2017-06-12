/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_EXSTOR_DELMODE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   TDOLE_DELETE_LOCAL(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     1),  TDOLE_DELETE_REMOTE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     2);
/* 25:   */   
/* 26:   */   private final int value;
/* 27:   */   
/* 28:   */   private TDAPI_EXSTOR_DELMODE(int value)
/* 29:   */   {
/* 30:32 */     this.value = value;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public int comEnumValue()
/* 34:   */   {
/* 35:33 */     return this.value;
/* 36:   */   }
/* 37:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_EXSTOR_DELMODE
 * JD-Core Version:    0.7.0.1
 */