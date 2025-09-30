package m2_demo.fast_code.repo;

public class DemoRepo {
    // find theo name hoac id => nhap vao 1 string sau do dung contain de xac dinh ca 2 truong/neu found thi thôi

    // method getAll(list<Class> c)
        // tạo list<class> name = new array;
        // đặt khối try, tạo list<String> nameString = ReadAndWrite.ReadFile(FINAL_NAME);
        // tạo String[] arr;
        // for (String line : nameString)
        // arr = line.split();
//       nếu có phần tử là đối tượng, tạo biến tham chiếu và gán = null
//       tạo for each với object đó, duyệt qua list của objectRepo.getListObject (khởi tạo tt object ở model và static block ở repo )
//       if(o.getID==arr[tại ptu object])
//       ktra nếu trùng id thì gán biến tham chiếu = oj, break luôn;
        // Class c = new C(format lại các phần tử bên trong vòng lặp for each)
        // name.add(c);
        // đặt khối catch và báo lỗi, return false nếu gặp lỗi;
        // return name;

    // method List<> findByKeyword(String keyword)
        // List<Class> list = getAll; List<Class> newList = new Arr;
        // for each duyệt qua (Class c : list);
        // ktra id riêng, name riêng
        // nếu id là int => String.valueOf(c.getId()).equals(keyword); newList.add(c);
        // nếu id và name là String => c.getId/getName.toLower.contains(keyword.toLower); newList.add(c);
        // return newList;
}
