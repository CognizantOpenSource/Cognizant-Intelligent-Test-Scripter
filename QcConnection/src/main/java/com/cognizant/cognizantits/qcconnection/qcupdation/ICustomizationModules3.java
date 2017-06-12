package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{109DCBCF-8D7D-4280-837B-4F950604B48B}")
public abstract interface ICustomizationModules3
  extends ICustomizationModules2
{
  @DISPID(7)
  @VTID(18)
  public abstract IList modules();
  
  @VTID(18)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object modules(int paramInt);
  
  @DISPID(8)
  @VTID(19)
  public abstract IModule module(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationModules3
 * JD-Core Version:    0.7.0.1
 */