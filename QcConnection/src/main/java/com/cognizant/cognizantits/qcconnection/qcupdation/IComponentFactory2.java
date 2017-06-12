package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{EAB7E2A5-8E0C-4DFE-A963-9AD073A9F2DC}")
public abstract interface IComponentFactory2
  extends IComponentFactory
{
  @DISPID(74)
  @VTID(18)
  public abstract String convertManualTestToComponent(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  @DISPID(75)
  @VTID(19)
  public abstract String convertAllManualTestsInFolder(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3);
  
  @DISPID(76)
  @VTID(20)
  public abstract void mail(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentFactory2
 * JD-Core Version:    0.7.0.1
 */