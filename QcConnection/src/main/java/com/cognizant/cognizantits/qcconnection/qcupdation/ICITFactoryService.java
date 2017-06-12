package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{AAEF1B4C-4B50-4502-BE8E-11AD9A78B9E7}")
public abstract interface ICITFactoryService
  extends Com4jObject
{
  @VTID(3)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createApplicationEntityFactory(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @VTID(4)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createApplicationImpactFactory(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @VTID(5)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createChangeEntityFactory(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICITFactoryService
 * JD-Core Version:    0.7.0.1
 */