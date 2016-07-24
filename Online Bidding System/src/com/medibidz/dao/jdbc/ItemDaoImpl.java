package com.medibidz.dao.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.medibidz.dao.ItemDao;
import com.medibidz.dao.exception.DAOException;
import com.medibidz.entity.Bid;
import com.medibidz.entity.Item;
import com.medibidz.entity.ItemImage;
import com.medibidz.entity.SearchCriteria;
import com.medibidz.entity.User;
import com.medibidz.util.DBUtil;

public class ItemDaoImpl extends BaseDao implements ItemDao {

	public List<Item> getItemsByCategoryName(String categoryName) {

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id from item_info where active_status=1 and bid_status=1 and category_name=?");
			pst.setString(1, categoryName);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), 0);

					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}

	public void addItem(Item item) {

		int activeStatus = 0;
		int bidStatus = 1;
		Connection con = null;
		try {

			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into item_info  (category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, item.getCategoryName());
			pst.setString(2, item.getItemName());
			pst.setString(3, item.getDescription());
			
			pst.setDate(4, new Date(item.getLastDate().getTime()));
			pst.setDouble(5, item.getStartBidPrice());
			pst.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));
			if (item.getImage1() != null) {
				int id = addImage(item.getImage1(), con);
				pst.setInt(7, id);
			} else {
				pst.setObject(7, null);
			}
			if (item.getImage2() != null) {
				int id = addImage(item.getImage2(), con);
				pst.setInt(8, id);
			} else {
				pst.setObject(8, null);
			}
			if (item.getImage3() != null) {
				int id = addImage(item.getImage3(), con);
				pst.setInt(9, id);
			} else {
				pst.setObject(9, null);
			}

			pst.setInt(10, item.getSeller().getId());
			pst.setInt(11, activeStatus);
			pst.setInt(12, bidStatus);

			pst.executeUpdate();

			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
			throw new DAOException(e1.getMessage());
		}

		DBUtil.closeConnection(con);

	}

	public List<Item> getFreeItems() {

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select item_id,item_name,description,last_date,start_bid_price,image_id1,i.seller_id,u.first_name,u.last_name from item_info i,User u where i.seller_id=u.id and i.active_status=1 and bid_status=1 and start_bid_price<=0.0");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getDate(4), rs.getDouble(5),
							new ItemImage(rs.getInt(6)), new User(rs.getInt(7),
									rs.getString(8), rs.getString(9)));

					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}

	public double getMaxBid(int itemId) {
		Connection con = null;
		double maxPrice = 0.0;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select max(bid_price) from item_bids b where b.item_id=?");
			pst.setInt(1, itemId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				maxPrice = rs.getDouble(1);
			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return maxPrice;

	}

	public int getCountBidder(int itemId) {
		Connection con = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select count(buyer_id) from item_bids b,item_info i where i.item_id=b.item_id and b.item_id=?");
			pst.setInt(1, itemId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return count;
	}

	public List<Item> getItemBySeller(int sellerId) {
		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3 from item_info where seller_id=?");
			pst.setInt(1, sellerId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)));

					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}
	
	public Item getItem(Integer id)
	{
		
		Connection con = null;
		Item item=new Item();
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from item_info where item_id=? and active_status=? and bid_status=?");
			pst.setInt(1, id);
			pst.setInt(2, 1);
			pst.setInt(3, 1);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				
	
				

				item = new Item(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getDouble(6), rs.getDate(7), new ItemImage(
								rs.getInt(8)), new ItemImage(rs.getInt(9)),
						new ItemImage(rs.getInt(10)));

				}

			
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		return item;
	}

	/*
	 * public List<Item> getItemByBuyer(int buyerId) { ArrayList<Item> al =
	 * null; Connection con = null; try { con = DBUtil.getConnection();
	 * PreparedStatement pst = con.prepareStatement(
	 * "select b.bid_date,b.bid_price,b.item_id,i.category_name,i.item_name,i.description,u.first_name,u.last_name,i.image_id1,i.image_id2,i.image_id3 from item_bids b,item_info i,user u where b.buyer_id=u.id and i.item_id=b.item_id and i.bid_status=1 and u.id=i.seller_id and b.buyer_id=?"
	 * ); pst.setInt(1,buyerId); ResultSet rs = pst.executeQuery(); if
	 * (rs.next()) { al = new ArrayList<Item>(); do { Item item= new
	 * Item(rs.getDate(1),rs.getDouble(2),rs.getInt(3), rs.getString(4),
	 * rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),new
	 * ItemImage(rs.getInt(9)),new ItemImage(rs.getInt(10)),new
	 * ItemImage(rs.getInt(11))); al.add(item); } while (rs.next()); }
	 * rs.close(); pst.close();
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); }
	 * 
	 * DBUtil.closeConnection(con); return al; }
	 */

	/*
	 * public List<Deal> getDealsByBuyer(int buyerId) { ArrayList<Deal> al =
	 * null; Connection con = null; try { con = DBUtil.getConnection();
	 * PreparedStatement pst = con
	 * .prepareStatement("select * from deal_info where buyer_id=?");
	 * pst.setInt(1, buyerId); ResultSet rs = pst.executeQuery(); if (rs.next())
	 * { al = new ArrayList<Deal>(); do { Deal deal = new Deal(rs.getInt(1),
	 * rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6),
	 * rs.getDouble(7)); al.add(deal); } while (rs.next());
	 * 
	 * } rs.close(); pst.close();
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); }
	 * 
	 * DBUtil.closeConnection(con); return al; }
	 * 
	 * public List<Deal> getDealsBySeller(int sellerId) { ArrayList<Deal> al =
	 * null; Connection con = null; try { con = DBUtil.getConnection();
	 * PreparedStatement pst = con
	 * .prepareStatement("select * from deal_info where seller_id=?");
	 * pst.setInt(1, sellerId); ResultSet rs = pst.executeQuery(); if
	 * (rs.next()) {
	 * 
	 * al = new ArrayList<Deal>(); do { Deal deal = new Deal(rs.getInt(1),
	 * rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6),
	 * rs.getDouble(7)); al.add(deal); } while (rs.next());
	 * 
	 * } rs.close(); pst.close();
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); }
	 * 
	 * DBUtil.closeConnection(con); return al; }
	 */
	public void addBid(int itemId, int buyerId, double price) {
			
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into item_bids(bid_date,bid_price,buyer_id,item_id,buyer_deal_status,seller_deal_status) values(?,?,?,?,0,0)");

			pst.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
			pst.setDouble(2, price);
			pst.setInt(3, buyerId);
			pst.setInt(4, itemId);
			pst.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
	}

	public List<Bid> getBidsForItem(int itemId) {
		ArrayList<Bid> al = null;
		Connection con = null;
		try {
			al = new ArrayList<Bid>();
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT b.bid_id,b.bid_date,b.bid_price,u.first_name,u.last_name,u.email_id,u.id FROM item_bids b,USER u WHERE b.buyer_id=u.id AND b.item_id=? order by b.bid_date");
			pst.setInt(1, itemId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				do {
					User u = new User();
					u.setFirstName(rs.getString(4));
					u.setLastName(rs.getString(5));
					u.setEmail(rs.getString(6));
					u.setId(rs.getInt(7));
					Bid bid = new Bid(rs.getInt(1), rs.getDate(2),
							rs.getDouble(3), u, null);
					al.add(bid);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}

	public List<Item> getAllItems()// insertion date?
	{

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();

			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where active_status=1 and bid_status=1 ");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), rs.getInt(12));
					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}

	public List<Item> getNewItems()// insertion date?
	{

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();

			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where active_status=? ");
			int status = 0;
			pst.setInt(1, status);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), rs.getInt(12));
					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}

	public List<Item> getItemsByPrice(int min,int max) {
		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		
				PreparedStatement pst = con
						.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where active_status=1 and bid_status=1 and start_bid_price between ? and ? order by start_bid_price");
				pst.setInt(1, min);
				pst.setInt(2, max);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					al = new ArrayList<Item>();
					do {
						Item item = new Item(rs.getInt(1), rs.getString(2),
								rs.getString(3), rs.getString(4),
								rs.getDate(5), rs.getDouble(6), rs.getDate(7),
								new ItemImage(rs.getInt(8)), new ItemImage(
										rs.getInt(9)), new ItemImage(
										rs.getInt(10)),
								new User(rs.getInt(11)), rs.getInt(12));

						al.add(item);
					} while (rs.next());

				}
				rs.close();
				pst.close();
			

			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}

	public List<Item> getRecentItemsForBid()
	{
		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where active_status=1 and bid_status=1");
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), rs.getInt(12));

					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}

	public List<Item> getItemsbyBidClosing() {

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM item_info WHERE active_status=1 AND bid_status=1  ORDER BY last_date LIMIT 6");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), rs.getInt(12));
					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}

	public void validateItem(int itemId) {

		Connection con = null;
		try {

			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("update item_info set active_status=1 where item_id=?");
			pst.setInt(1, itemId);
			pst.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
	}

	public Item getNewItem(int itmId) {
		Item itm = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where item_id=? ");
			pst.setInt(1, itmId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				itm = new Item(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getDouble(6),
						rs.getDate(7), new ItemImage(rs.getInt(8)),
						new ItemImage(rs.getInt(9)), new ItemImage(
								rs.getInt(10)), new User(rs.getInt(11)),
						rs.getInt(12));
			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		DBUtil.closeConnection(con);
		return itm;

	}

	public List<Item> searchItem(SearchCriteria search) {
		ArrayList<Item> al = null;
		Connection con = null;
		try {

			con = DBUtil.getConnection();

			Statement st = con.createStatement();

			String sql1 = "select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id from item_info where active_status=1 and bid_status=1 and category_name like '%"
					+ search.getSearchText() + "%'";
			String sql2 = "select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id from item_info where active_status=1 and bid_status=1 and item_name like '%"
					+ search.getSearchText() + "%'";
			String sql3 = "select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id from item_info where active_status=1 and bid_status=1 and description like '%"
					+ search.getSearchText() + "%'";

			ResultSet rs = st.executeQuery(sql1);

			boolean found = false;
			if (rs.next()) {
				found = true;
				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), 0);
					al.add(item);
				} while (rs.next());

			}

			if (!found) {
				rs = st.executeQuery(sql2);

				if (rs.next())
				{
					

					found = true;
					al = new ArrayList<Item>();
					do {
						Item item = new Item(rs.getInt(1), rs.getString(2),
								rs.getString(3), rs.getString(4),
								rs.getDate(5), rs.getDouble(6), rs.getDate(7),
								new ItemImage(rs.getInt(8)), new ItemImage(
										rs.getInt(9)), new ItemImage(
										rs.getInt(10)),
								new User(rs.getInt(11)), 0);
						al.add(item);
					} while (rs.next());

				}

			}

			if (!found) {
				rs = st.executeQuery(sql3);

				if (rs.next()) {

					al = new ArrayList<Item>();
					do {
						Item item = new Item(rs.getInt(1), rs.getString(2),
								rs.getString(3), rs.getString(4),
								rs.getDate(5), rs.getDouble(6), rs.getDate(7),
								new ItemImage(rs.getInt(8)), new ItemImage(
										rs.getInt(9)), new ItemImage(
										rs.getInt(10)),
								new User(rs.getInt(11)), 0);

						al.add(item);
					} while (rs.next());

				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}

	public Item findItemByBid(int id) {

		return null;
	}

	public InputStream getImageData(int imageId) {

		Connection con = null;
		try {
			con = DBUtil.getConnection();
			return getImageAsStream(imageId, con);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(con);
		}
		return null;

	}

	public void delete(int itemId) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("delete * from item_info where item_id=?");
			pst.setInt(1, itemId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				PreparedStatement pst1 = con
						.prepareStatement("delete * from item_images where item_id=?");
				PreparedStatement pst2 = con
						.prepareStatement("delete * from item_bids where item_id=?");
				
				pst1.setInt(1, itemId);
				pst2.setInt(1, itemId);
				ResultSet rs1 = pst1.executeQuery();
				ResultSet rs2 = pst2.executeQuery();
				rs2.close();
				pst2.close();
				rs1.close();
				pst1.close();
				rs.close();
				pst.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Bid> getActiveBidsForBuyer(int buyerId) {
		ArrayList<Bid> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst1 = con
					.prepareStatement("select max(bid_price),count(*) from item_bids b where b.item_id=?");
			PreparedStatement pst = con
					.prepareStatement("select b.bid_id,b.bid_date,b.bid_price,i.item_id,i.category_name,i.item_name,i.description,i.image_id1,i.image_id2,i.image_id3,u.id,u.first_name,u.last_name,b.buyer_deal_status from item_bids b,item_info i,user u where i.seller_id=u.id and i.item_id=b.item_id and i.bid_status=1 and b.buyer_id=?");
			pst.setInt(1, buyerId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				al = new ArrayList<Bid>();
				Bid b;
				do {
					Item item = new Item(rs.getInt(4), rs.getString(5),
							rs.getString(6), rs.getString(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11), rs.getString(12),
									rs.getString(13)));
					
					b = new Bid(rs.getInt(1), rs.getDate(2), rs.getDouble(3),
							null, item);
					b.setDealStatus(rs.getInt("buyer_deal_status"));
					pst1.setInt(1, rs.getInt(4));
					ResultSet rs1 = pst1.executeQuery();
					if (rs1.next()) {
						double maxBidPrice = rs1.getDouble(1);
						int count = rs1.getInt(2);
						item.setMaxBidPrice(maxBidPrice);
						item.setTotalBidCount(count);
					}
					rs1.close();
					al.add(b);
				} while (rs.next());
			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;

	}

	@Override
	public List<Item> displayRecentItemsForBid() {
		// TODO Auto-generated method stub

		ArrayList<Item> al = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select item_id,category_name,item_name,description,last_date,start_bid_price,insertion_date,image_id1,image_id2,image_id3,seller_id,active_status,bid_status from item_info where active_status=1 and bid_status=1 ORDER BY insertion_date LIMIT 10");
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				al = new ArrayList<Item>();
				do {
					Item item = new Item(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getDouble(6), rs.getDate(7), new ItemImage(
									rs.getInt(8)), new ItemImage(rs.getInt(9)),
							new ItemImage(rs.getInt(10)), new User(
									rs.getInt(11)), rs.getInt(12));

					al.add(item);
				} while (rs.next());

			}
			rs.close();
			pst.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);
		return al;
	}
	
	public void updateDealStatus(int bidId)
	{
		
		Connection con = null;
		try {

			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("update item_bids set buyer_deal_status=1 where bid_id=?");
			pst.setInt(1, bidId);
			pst.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);

		
		
	}
	
	
	public boolean getDealStatus(int bidId)
{
		boolean chk=false;
		
		Connection con = null;
		try {

			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("select buyer_deal_status from item_bids where bid_id=?");
			pst.setInt(1, bidId);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				Integer status=rs.getInt(1);
				
				if(status==1)
					chk=true;
				
			}
			
			
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);

		
		return chk;
		
	}
	
	public boolean getDealStatusSeller(int bidId)
	{
			boolean chk=false;
			
			Connection con = null;
			try {

				con = DBUtil.getConnection();
				PreparedStatement pst = con
						.prepareStatement("select seller_deal_status from item_bids where bid_id=?");
				pst.setInt(1, bidId);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					Integer status=rs.getInt(1);
					
					if(status==1)
						chk=true;
					
				}
				
				
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			DBUtil.closeConnection(con);

			
			return chk;
			

	}
	
	public void updateDealStatusSeller(int bidId)
	{
		
		Connection con = null;
		try {

			con = DBUtil.getConnection();
			PreparedStatement pst = con
					.prepareStatement("update item_bids set seller_deal_status=1 where bid_id=?");
			pst.setInt(1, bidId);
			pst.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		DBUtil.closeConnection(con);

		
		
	}

}
