/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_COPY_PASTE_MODES
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   COPY_PASTE_NO_LINKED_TEST_MODE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     0),  COPY_PASTE_USE_LINKED_TEST_MODE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     1),  COPY_PASTE_CREATE_LINKED_TEST_MODE(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     2),  COPY_PASTE_NO_RELATED_ENTITIES_MODE(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     4),  COPY_PASTE_USE_RELATED_ENTITIES_MODE(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:55 */     8),  COPY_PASTE_CREATE_RELATED_ENTITIES_MODE(
/* 49:   */   
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:   */ 
/* 55:   */ 
/* 56:64 */     16);
/* 57:   */   
/* 58:   */   private final int value;
/* 59:   */   
/* 60:   */   private TDAPI_COPY_PASTE_MODES(int value)
/* 61:   */   {
/* 62:68 */     this.value = value;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public int comEnumValue()
/* 66:   */   {
/* 67:69 */     return this.value;
/* 68:   */   }
/* 69:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_COPY_PASTE_MODES
 * JD-Core Version:    0.7.0.1
 */