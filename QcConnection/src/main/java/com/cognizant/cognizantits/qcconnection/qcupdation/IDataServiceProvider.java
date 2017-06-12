package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{4EA0B972-9132-4485-90BE-AE502F08F784}")
public abstract interface IDataServiceProvider
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject itemByTypeAndId(int paramInt1, int paramInt2);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject itemByTableNameAndId(String paramString, int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract String convertObjectTypeToName(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDataServiceProvider
 * JD-Core Version:    0.7.0.1
 */