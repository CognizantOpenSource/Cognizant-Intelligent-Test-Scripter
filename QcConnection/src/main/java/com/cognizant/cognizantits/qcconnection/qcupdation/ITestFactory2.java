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

@IID("{F41D8969-F741-4836-A1C5-48BEC37B7B40}")
public abstract interface ITestFactory2
  extends ITestFactory
{
  @DISPID(16)
  @VTID(25)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectSummaryGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(17)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectTrendGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectProgressGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("0") int paramInt1, @Optional @DefaultValue("1") int paramInt2, @Optional @DefaultValue("0") int paramInt3, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestFactory2
 * JD-Core Version:    0.7.0.1
 */