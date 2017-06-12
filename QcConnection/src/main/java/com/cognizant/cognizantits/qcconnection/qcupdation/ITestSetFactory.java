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

@IID("{6199FE11-C44D-4712-99DF-4F5EF3F80A29}")
public abstract interface ITestSetFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildSummaryGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("0") int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(9)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildProgressGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt2, @Optional @DefaultValue("1") int paramInt3, @Optional @DefaultValue("0") int paramInt4, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(10)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildTrendGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(11)
  @VTID(19)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildPerfGraph(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt2, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(12)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildProgressGraphEx(int paramInt1, @Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("0") int paramInt2, @Optional @DefaultValue("1") int paramInt3, @Optional @DefaultValue("0") int paramInt4, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFactory
 * JD-Core Version:    0.7.0.1
 */