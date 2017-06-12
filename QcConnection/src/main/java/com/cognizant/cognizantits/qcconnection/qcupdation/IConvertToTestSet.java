package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.VTID;

@IID("{1194CDE0-F996-41BE-AE10-EDFFD7587B47}")
public abstract interface IConvertToTestSet
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract int convertEntityToTestSet(int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IConvertToTestSet
 * JD-Core Version:    0.7.0.1
 */