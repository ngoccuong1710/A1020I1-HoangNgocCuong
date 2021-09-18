import {IKhachHang} from "./KhachHang";

export interface ISoTietKiem {
  id: number;
  khachHang: IKhachHang;
  ngayMoSo: string;
  thoiGianBatDauGui: string;
  kyHan: string;
  soTienGui: string;
  laiSuat: string;
  uuDai: string;
}
