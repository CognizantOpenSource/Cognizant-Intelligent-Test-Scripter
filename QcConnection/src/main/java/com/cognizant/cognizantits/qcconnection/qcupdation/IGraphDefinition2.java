package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{AF2CF201-C24C-4420-88E9-188CA12B5B46}")
public abstract interface IGraphDefinition2
  extends IGraphDefinition
{
  @DISPID(6)
  @VTID(14)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object getPropertyByName(String paramString);
  
  @DISPID(7)
  @VTID(15)
  public abstract void setPropertyByName(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGraphDefinition2
 * JD-Core Version:    0.7.0.1
 */