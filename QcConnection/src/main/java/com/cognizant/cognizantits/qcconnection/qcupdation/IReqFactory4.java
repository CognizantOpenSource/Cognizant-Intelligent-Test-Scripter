package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3F14A1AC-5E49-4996-81B4-17E7AE2D5D61}")
public abstract interface IReqFactory4
  extends IReqFactory3
{
  @DISPID(27)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectSummaryGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
  
  @DISPID(28)
  @VTID(36)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectProgressGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("0") int paramInt1, @Optional @DefaultValue("1") int paramInt2, @Optional @DefaultValue("0") int paramInt3, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3, @Optional @DefaultValue("0") boolean paramBoolean4);
  
  @DISPID(29)
  @VTID(37)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectTrendGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqFactory4
 * JD-Core Version:    0.7.0.1
 */