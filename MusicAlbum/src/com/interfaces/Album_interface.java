package com.interfaces;

import java.util.List;

import com.model.AlbumtypeMaster;

public interface Album_interface {
	
	public List<AlbumtypeMaster> getInfo();
	public boolean insertDetails(AlbumtypeMaster atm);
	public boolean deleteData(int a);
	public boolean updateDetails(AlbumtypeMaster atm);

}
