package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{B1F47936-EFAC-4AEE-9876-8110B16F037D}")
public abstract interface IBaseFactoryEx
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  public abstract void mail(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseFactoryEx
 * JD-Core Version:    0.7.0.1
 */