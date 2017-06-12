package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9CE1D9AD-3CCE-4FE2-B750-350947B0ED77}")
public abstract interface IExcelReportQuery
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void setParamValue(String paramString1, String paramString2);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject execute(int paramInt, Holder<Integer> paramHolder, @Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(3)
  @VTID(9)
  public abstract void cancel();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExcelReportQuery
 * JD-Core Version:    0.7.0.1
 */