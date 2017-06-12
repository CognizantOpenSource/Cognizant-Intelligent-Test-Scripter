package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{118EEC21-E08B-4E25-AA04-2BE09714FDF3}")
public abstract interface ISupportParameterValues
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IParameterValueFactory parameterValueFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportParameterValues
 * JD-Core Version:    0.7.0.1
 */