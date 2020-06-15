package designpatterns.composite.zyr;

public class CompositeZYRMain {


    public static void main(String[] args) {
        Directory life = new Directory("我的生活");
        File eat = new File("吃火锅", 100);
        File sleep = new File("睡觉", 100);
        File study = new File("学习", 100);
        life.add(eat);
        life.add(sleep);
        life.add(study);

        Directory work = new Directory("我的工作");
        File write = new File("写博客", 200);
        File paper = new File("写论文", 200);
        File homework = new File("写家庭作业", 200);
        work.add(write);
        work.add(paper);
        work.add(homework);

        Directory relax = new Directory("我的休闲");
        File music = new File("听听音乐", 200);
        File walk = new File("出去转转", 200);
        relax.add(music);
        relax.add(walk);

        Directory read = new Directory("我的阅读");
        File book = new File("学习书籍", 200);
        File novel = new File("娱乐小说", 200);
        read.add(book);
        read.add(novel);


        Directory root = new Directory("根目录");

        root.add(life);
        root.add(work);
        root.add(relax);
        root.add(read);

        root.printList("D:");
        System.out.println("=================");
        work.printList("work");
        System.out.println("=================");
        novel.printList("novel");
    }
}
