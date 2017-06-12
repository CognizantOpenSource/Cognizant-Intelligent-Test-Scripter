package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{1E57BFE9-717E-461E-97F1-8E7F2AA75F44}")
public abstract interface ISupportTestParameters
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract ITestParameterFactory testParameterFactory();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean isTestParametersSupported();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isTestClass();
  
  @DISPID(3)
  @VTID(10)
  public abstract void isTestClass(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportTestParameters
 * JD-Core Version:    0.7.0.1
 */