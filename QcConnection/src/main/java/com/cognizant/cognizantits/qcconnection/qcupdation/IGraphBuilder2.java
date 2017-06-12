package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9D495F53-26E3-4A98-8EF1-DF7A7F65B53C}")
public abstract interface IGraphBuilder2
  extends IGraphBuilder
{
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createGraphDefinitionByTableName(String paramString, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGraphBuilder2
 * JD-Core Version:    0.7.0.1
 */