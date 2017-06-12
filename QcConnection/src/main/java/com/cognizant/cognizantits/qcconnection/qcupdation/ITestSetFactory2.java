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

@IID("{CE2D2089-4D9F-4740-985C-13114342AB98}")
public abstract interface ITestSetFactory2
  extends ITestSetFactory
{
  @DISPID(13)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectSummaryGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4, @Optional @DefaultValue("0") int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(14)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectTrendGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("0") int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(16)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildMultiProjectProgressGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("0") int paramInt2, @Optional @DefaultValue("1") int paramInt3, @Optional @DefaultValue("0") int paramInt4, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFactory2
 * JD-Core Version:    0.7.0.1
 */