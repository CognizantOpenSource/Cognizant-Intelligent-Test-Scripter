package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{9EF01CB3-549B-4F0B-9AD9-634916324844}")
public abstract interface ICrossProjectAPI
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList getEntitiesFieldIntersection(IList paramIList1, IList paramIList2, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICrossProjectAPI
 * JD-Core Version:    0.7.0.1
 */