package day1;



public class BTree {
			  private int T;

			  // Node creation
			  public class Node {
			    int n;
			    int key[] = new int[2 * T - 1];
			    long pos[] = new long[2 * T - 1];
			    Node child[] = new Node[2 * T];
			    boolean leaf = true;

			    public int Find(int k) {
			      for (int i = 0; i < this.n; i++) {
			        if (this.key[i] == k) {
			          return i;
			        }
			      }
			      return -1;
			    };
			  }

			  public BTree(int t) {
			    T = t;
			    root = new Node();
			    root.n = 0;
			    root.leaf = true;
			  }

			  public Node root;

			  // Search key
			  private long Search(Node x, int key) {
			    int i = 0;
			    if (x == null)
			      return x.pos[0];
			    for (i = 0; i < x.n; i++) {
			      if (key < x.key[i]) {
			        break;
			      }
			      if (key == x.key[i]) {
			        return x.pos[i];
			      }
			    }
			    if (x.leaf) {
			      return -1234;
			    } else {
			      return Search(x.child[i], key);
			    }
			  }
			// Check if present
			  public long Contain(int k) {
				  long x = this.Search(root, k);
			    if (x== -1234) {
			      return -1234;
			    } else {
			      return x;
			    }
			  }

			  // Splitting the node
			  private void Split(Node x, int poso, Node y) {
			    Node z = new Node();
			    z.leaf = y.leaf;
			    z.n = T - 1;
			    for (int j = 0; j < T - 1; j++) {
			      z.key[j] = y.key[j + T];
			      z.pos[j] = y.pos[j + T ];
			    }
			    if (!y.leaf) {
			      for (int j = 0; j < T; j++) {
			        z.child[j] = y.child[j + T];
			      }
			    }
			    y.n = T - 1;
			    for (int j = x.n; j >= poso + 1; j--) {
			      x.child[j + 1] = x.child[j];
			    }
			    x.child[poso + 1] = z;

			    for (int j = x.n - 1; j >= poso; j--) {
			      x.key[j + 1] = x.key[j];
			      x.pos[j + 1] = x.pos[j];
			    }
			    x.key[poso] = y.key[T - 1];
			    x.pos[poso] = y.pos[T-1];
			    x.n = x.n + 1;
			  }

			  // Inserting a value
			  public void Insert(final int key,final long pos) {
			    Node r = root;
			    if (r.n == 2 * T - 1) {
			      Node s = new Node();
			      root = s;
			      s.leaf = false;
			      s.n = 0;
			      s.child[0] = r;
			      Split(s, 0, r);
			      insertValue(s, key,pos);
			    } else {
			      insertValue(r, key,pos);
			    }
			  }

			  // Insert the node
			  final private void insertValue(Node x, int k,long pos) {

			    if (x.leaf) {
			      int i = 0;
			      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
			        x.key[i + 1] = x.key[i];
			        x.pos[i +1 ] = x.pos[i];
			      }
			      x.key[i + 1] = k;
			      x.pos[i + 1] = pos;
			      x.n = x.n + 1;
			    } else {
			      int i = 0;
			      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
			      }
			      ;
			      i++;
			      Node tmp = x.child[i];
			      if (tmp.n == 2 * T - 1) {
			        Split(x, i, tmp);
			        if (k > x.key[i]) {
			          i++;
			        }
			      }
			      insertValue(x.child[i], k,pos);
			    }

			  }

			  public void Show() {
			    Show(root);
			  }

			  // Display
			  private void Show(Node x) {
			    assert (x == null);
			
			    for (int i = 0; i < x.n; i++) {
			      System.out.print("( "+x.key[i] + " "+x.pos[i]+")" + " ");
			      
			    }
			    System.out.print("\n");
			    if (!x.leaf) {
			      for (int i = 0; i < x.n + 1; i++) {
			        Show(x.child[i]);
			      }
			    }
			  }

			  
			  void Remove(Node x, int key , long poso) {
				    int pos = x.Find(key);
				    if (pos != -1) {
				      if (x.leaf) {
				        int i = 0;
				        for (i = 0; i < x.n && x.key[i] != key; i++) {
				        }
				        ;
				        for (; i < x.n; i++) {
				          if (i != 2 * T - 2) {
				            x.key[i] = x.key[i + 1];
				            x.pos[i] = x.pos[i + 1];
				            
				          }
				        }
				        x.n--;
				        return;
				      }
				      if (!x.leaf) {

				        Node pred = x.child[pos];
				        int predKey = 0;
				        long predpos =0;
				        if (pred.n >= T) {
				          for (;;) {
				            if (pred.leaf) {
				              System.out.println(pred.n);
				              predKey = pred.key[pred.n - 1];
				              predpos = pred.pos[pred.n -1];
				              break;
				            } else {
				              pred = pred.child[pred.n];
				            }
				          }
				          Remove(pred, predKey,predpos);
				          x.key[pos] = predKey;
				          x.pos[pos] = predpos;
				          
				          return;
				        }

				        Node nextNode = x.child[pos + 1];
				        if (nextNode.n >= T) {
				          int nextKey = nextNode.key[0];
				          long nextpos = nextNode.pos[0];
				          if (!nextNode.leaf) {
				            nextNode = nextNode.child[0];
				            for (;;) {
				              if (nextNode.leaf) {
				                nextKey = nextNode.key[nextNode.n - 1];
				                nextpos = nextNode.pos[nextNode.n -1];
				                break;
				              } else {
				                nextNode = nextNode.child[nextNode.n];
				              }
				            }
				          }
				          Remove(nextNode, nextKey,nextpos);
				          x.key[pos] = nextKey;
				          x.pos[pos] = nextpos;
				          return;
				        }

				        int temp = pred.n + 1;
				        pred.key[pred.n++] = x.key[pos];
				        pred.pos[pred.n] = x.pos[pos];
				        for (int i = 0, j = pred.n,ji = pred.n; i < nextNode.n; i++) {
				          pred.key[j++] = nextNode.key[i];
				          pred.pos[ji++] = nextNode.pos[i];
				          pred.n++;
				        }
				        for (int i = 0; i < nextNode.n + 1; i++) {
				          pred.child[temp++] = nextNode.child[i];
				        }

				        x.child[pos] = pred;
				        for (int i = pos; i < x.n; i++) {
				          if (i != 2 * T - 2) {
				            x.key[i] = x.key[i + 1];
				            x.pos[i] = x.pos[i + 1];
				          }
				        }
				        for (int i = pos + 1; i < x.n + 1; i++) {
				          if (i != 2 * T - 1) {
				            x.child[i] = x.child[i + 1];
				          }
				        }
				        x.n--;
				        if (x.n == 0) {
				          if (x == root) {
				            root = x.child[0];
				          }
				          x = x.child[0];
				        }
				        Remove(pred, key,poso);
				        return;
				      }
				    } else {
				      for (pos = 0; pos < x.n; pos++) {
				        if (x.key[pos] > key) {
				          break;
				        }
				      }
				      Node tmp = x.child[pos];
				      if (tmp.n >= T) {
				        Remove(tmp, key,poso);
				        return;
				      }
				      if (true) {
				        Node nb = null;
				        int devider = -1;
				        long devider_pos = -1;

				        if (pos != x.n && x.child[pos + 1].n >= T) {
				          devider = x.key[pos];
				          devider_pos = x.pos[pos];
				          nb = x.child[pos + 1];
				          x.key[pos] = nb.key[0];
				          x.pos[pos] = nb.key[0];
				          tmp.key[tmp.n++] = devider;
				          tmp.pos[tmp.n]=devider_pos;
				          tmp.child[tmp.n] = nb.child[0];
				          for (int i = 1; i < nb.n; i++) {
				            nb.key[i - 1] = nb.key[i];
				            nb.pos[i -1]=nb.pos[i];
				          }
				          for (int i = 1; i <= nb.n; i++) {
				            nb.child[i - 1] = nb.child[i];
				          }
				          nb.n--;
				          Remove(tmp, key,poso);
				          return;
				        } else if (pos != 0 && x.child[pos - 1].n >= T) {

				          devider = x.key[pos - 1];
				          devider_pos = x.pos[pos-1];
				          nb = x.child[pos - 1];
				          x.key[pos - 1] = nb.key[nb.n - 1];
				          x.pos[pos -1]= nb.pos[nb.n-1];
				          Node child = nb.child[nb.n];
				          nb.n--;

				          for (int i = tmp.n; i > 0; i--) {
				            tmp.key[i] = tmp.key[i - 1];
				            tmp.pos[i] = tmp.pos[i-1];
				          }
				          tmp.key[0] = devider;
				          tmp.pos[0] = devider_pos;
 				          for (int i = tmp.n + 1; i > 0; i--) {
				            tmp.child[i] = tmp.child[i - 1];
				          }
				          tmp.child[0] = child;
				          tmp.n++;
				          Remove(tmp, key,poso);
				          return;
				        } else {
				          Node lt = null;
				          Node rt = null;
				          if (pos != x.n) {
				            devider = x.key[pos];
				            devider_pos=x.pos[pos];
				            lt = x.child[pos];
				            rt = x.child[pos + 1];
				          } else {
				            devider = x.key[pos - 1];
				            devider_pos = x.pos[pos-1];
				            rt = x.child[pos];
				            lt = x.child[pos - 1];
				            pos--;
				          }
				          for (int i = pos; i < x.n - 1; i++) {
				            x.key[i] = x.key[i + 1];
				            x.pos[i] = x.pos[i+1];
				          }
				          for (int i = pos + 1; i < x.n; i++) {
				            x.child[i] = x.child[i + 1];
				          }
				          x.n--;
				          lt.key[lt.n++] = devider;
				          lt.pos[lt.n] = devider_pos;

				          for (int i = 0, j = lt.n; i < rt.n + 1; i++, j++) {
				            if (i < rt.n) {
				              lt.key[j] = rt.key[i];
				              lt.pos[j] = rt.pos[i];
				            }
				            lt.child[j] = rt.child[i];
				          }
				          lt.n += rt.n;
				          if (x.n == 0) {
				            if (x == root) {
				              root = x.child[0];
				            }
				            x = x.child[0];
				          }
				          Remove(lt, key,poso);
				          return;
				        }
				      }
				    }
				  }

			  public static void main(String[] args) {}
			}


