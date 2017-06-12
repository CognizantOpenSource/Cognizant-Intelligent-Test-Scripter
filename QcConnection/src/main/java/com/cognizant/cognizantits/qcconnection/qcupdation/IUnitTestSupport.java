package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

@IID("{24B17582-D52C-4074-8BD6-D7DD82705D15}")
public abstract interface IUnitTestSupport
  extends Com4jObject
{
  @VTID(3)
  public abstract void unitTestEnviromentOption(int paramInt);
  
  @VTID(4)
  public abstract void unitTestProfile(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IUnitTestSupport
 * JD-Core Version:    0.7.0.1
 */